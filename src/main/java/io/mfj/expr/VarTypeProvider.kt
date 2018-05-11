/*
Copyright 2018 Measures for Justice Institute.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package io.mfj.expr

interface VarTypeProvider {

	fun contains( varName:String ): Boolean

	/**
	 * Get the type for the specified variable.
	 *
	 * @param varName variable name
	 * @return variable type
	 * @throws IllegalArgumentException if the variable does not exist.
	 */
	operator fun get( varName:String ) : ExDataType

	/**
	 * Get a list of known variables.
	 *
	 * As variables can be dynamic, [get] may work for variables not returned by this method.
	 */
	fun getKnownVars(): Map<String,ExDataType> = emptyMap()

}

class ChainVarTypeProvider( vararg val vps:VarTypeProvider ): VarTypeProvider {

	override fun contains( varName:String ) = vps.any { vp -> vp.contains( varName ) }

	override fun get(varName:String):ExDataType {
		for ( vp in vps ) {
			if ( vp.contains( varName ) ) {
				return vp[varName]
			}
		}
		throw IllegalArgumentException( "No such variable \"${varName}\"." )
	}

	override fun getKnownVars():Map<String, ExDataType> =
			mutableMapOf<String,ExDataType>().apply {
				vps.forEach { putAll( it.getKnownVars() ) }
			}

}

class MapVarTypeProvider( private val map:Map<String,ExDataType> ): VarTypeProvider {

	constructor( vararg types:Pair<String,ExDataType> ): this( types.toMap() )

	override fun contains(varName:String):Boolean = map.containsKey( varName )

	override operator fun get(varName: String): ExDataType = map[varName] ?: throw IllegalArgumentException( "No such variable \"${varName}\"." )

	override fun getKnownVars():Map<String,ExDataType> = map

}

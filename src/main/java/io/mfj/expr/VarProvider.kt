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

interface VarProvider {

    fun contains(varName: String): Boolean

    /**
     * Get the value for the specified variable.
     *
     * @param varName Variable name
     * @return value (which may be null)
     * @throws IllegalArgumentException if there is no such variable.
     */
    operator fun get(varName: String): Any?

    fun getKnownVars() : Set<String>
}

object EmptyVarProvider : VarProvider {
    override fun contains(varName: String): Boolean = false
    override fun get(varName: String): Any? = throw IllegalArgumentException("No such variable \"${varName}\".")
    override fun getKnownVars(): Set<String> = emptySet()
}

class ChainVarProvider(vararg val vps: VarProvider) : VarProvider {

    override fun contains(varName: String) = vps.any { vp -> vp.contains(varName) }

    override fun get(varName: String): Any? {
        return vps.first { it.contains(varName) }.get(varName)
            ?: throw IllegalArgumentException("No such variable \"${varName}\".")
    }

    override fun getKnownVars(): Set<String> {
        return vps.flatMap { it.getKnownVars() }.toSet()
    }

}

open class MapVarProvider(private val map: Map<String, Any?>) : VarProvider {

    constructor(vararg values: Pair<String, Any?>) : this(values.toMap())

    override fun contains(varName: String): Boolean = map.containsKey(varName)

  override operator fun get(varName: String): Any? =
      if ( map.containsKey( varName ) ) {
        map[varName]
      } else {
        throw IllegalArgumentException( "No such variable \"${varName}\"." )
      }

    override fun getKnownVars(): Set<String> {
        return map.keys
    }

}

class MutableMapVarProvider(private val map: MutableMap<String, Any?>) : MapVarProvider(map) {

    constructor(vararg values: Pair<String, Any?>) : this(values.toMap().toMutableMap())

    override fun contains(varName: String): Boolean = map.containsKey(varName)

  override operator fun get(varName: String): Any? =
      if ( map.containsKey( varName ) ) {
        map[varName]
      } else {
        throw IllegalArgumentException( "No such variable \"${varName}\"." )
      }

    operator fun set(varName: String, value: Any?) {
        map[varName] = value
    }

}
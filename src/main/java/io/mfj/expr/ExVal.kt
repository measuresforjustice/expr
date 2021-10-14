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

// when parsing values (either a variable name or a literal),
// one of these objects is used.
// There is no type model at this point, so there is no type for variables, only for literals.
sealed class ExVal
class ExLit( val type:ExDataType, val value:String? ): ExVal()
class ExVar( val name:String ): ExVal()
class ExCom( val left:ExVal, val op: ExMathOpType, val right: ExVal): ExVal()
class ExList( val values:MutableList<ExVal> = mutableListOf()): ExVal()

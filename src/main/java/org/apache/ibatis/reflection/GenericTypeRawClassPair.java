/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author LuckyZhan
 **/
public final class GenericTypeRawClassPair {
  private final Type type;
  private final Class<?> rawClass;

  private GenericTypeRawClassPair(Type type, Class<?> rawClass){
    this.type = type;
    this.rawClass = rawClass;
  }

  public Type getType(){
    return type;
  }

  public Class<?> getRawClass(){
    return rawClass;
  }

  public static GenericTypeRawClassPair newGenericTypeRawClassPair(Type type, Class<?> rawClass){
    Objects.requireNonNull(rawClass, "rawClass must be present");
    if(type instanceof Class){
      type = null;
    }
    return new GenericTypeRawClassPair(type, rawClass);
  }

  public static GenericTypeRawClassPair newOnlyRawClassPair(Class<?> rawClass){
    return newGenericTypeRawClassPair(null, rawClass);
  }

}

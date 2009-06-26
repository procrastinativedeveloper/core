/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wicketstuff.ki.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.wicket.Page;
import org.wicketstuff.ki.KiAction;
import org.wicketstuff.ki.KiConstraint;


@Target( ElementType.TYPE )
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface KiSecurityConstraint {
  
  KiAction action() default KiAction.INSTANTIATE; 
  
  KiConstraint constraint();  
  String value() default "";

  // optional
  String loginMessage() default "";         // goes to INFO
  String unauthorizedMessage() default "";  // goes to ERROR

  // optional
  Class<? extends Page> loginPage() default Page.class;
  Class<? extends Page> unauthorizedPage() default Page.class;
}


/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.ki.component;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.jsecurity.SecurityUtils;
import org.wicketstuff.ki.page.LogoutPage;



public class SimpleAuthHeader extends Panel
{ 
	public SimpleAuthHeader(String id, Class<? extends Page> loginPage)
	{
	  super( id );
	  
	  // Welcome with logout
	  WebMarkupContainer welcome = new WebMarkupContainer( "welcome") {
	    @Override
      public boolean isVisible() {
	      return SecurityUtils.getSubject().getPrincipal() != null;
	    }
	  };
	  welcome.add( new Label( "name", new AbstractReadOnlyModel<String>() {
      @Override
      public String getObject() {
        return SecurityUtils.getSubject().getPrincipal().toString(); // ??
      }
	  }) );
	  welcome.add( new BookmarkablePageLink<Void>( "link", LogoutPage.class ) );
	  add( welcome );
	  
	  
	  // Login
    WebMarkupContainer login = new WebMarkupContainer( "login") {
      @Override
      public boolean isVisible() {
        return SecurityUtils.getSubject().getPrincipal() == null;
      }
    };
    login.add( new BookmarkablePageLink<Void>( "link", loginPage ) );
    add( login );
	}
}

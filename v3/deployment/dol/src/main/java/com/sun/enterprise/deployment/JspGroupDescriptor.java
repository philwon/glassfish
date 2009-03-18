/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.enterprise.deployment;

import java.util.Enumeration;
import java.util.Set;
import java.util.Vector;

/**
 */
public class JspGroupDescriptor extends Descriptor {
    
    private boolean elIgnored = false;
    private boolean scriptingInvalid = false;
    private Boolean isXml = null;
    private boolean deferredSyntaxAllowedAsLiteral = false;
    private boolean trimDirectiveWhitespaces = false;
    private Set urlPatterns = null;
    private Set includePreludes = null;
    private Set includeCodas = null;
    private String pageEncoding = null;
    private String defaultContentType = null;
    private String buffer = null;
    private boolean errorOnUndeclaredNamespace = false;
    
    /**
     * Return the set of URL pattern aliases for this group.
     */
    public Set getUrlPatternsSet() {
        if (this.urlPatterns == null) {
            this.urlPatterns = new OrderedSet();
        }
        return this.urlPatterns;
    }

    /**
     * Returns an enumeration of (String) URL pattern aliases for this 
     * group.
     */
    public Enumeration getUrlPatterns() {
        return (new Vector(this.getUrlPatternsSet())).elements();
    }
   
    /**
     * Adds an alias to this jsp group.
     */
    public void addUrlPattern(String urlPattern) {
        this.getUrlPatternsSet().add(urlPattern);

    }
   
    /**
     * Removes a URL pattern from this jsp group.
     */
    public void removeUrlPattern(String urlPattern) {
        this.getUrlPatternsSet().remove(urlPattern);

    }

    /**
     * Return the set of include prelude elements for this group.
     */
    public Set getIncludePreludeSet() {
        if (this.includePreludes == null) {
            this.includePreludes = new OrderedSet();
        }
        return this.includePreludes;
    }

    /**
     * Returns an enumeration of include prelude patterns for this 
     * group.
     */
    public Enumeration getIncludePreludes() {
        return (new Vector(this.getIncludePreludeSet())).elements();
    }
   
    /**
     * Adds an element
     */
    public void addIncludePrelude(String prelude) {
        this.getIncludePreludeSet().add(prelude);

    }
   
    /**
     * Removes an element 
     */
    public void removeIncludePrelude(String prelude) {
        this.getIncludePreludeSet().remove(prelude);

    }

    /**
     * Return the set of include coda elements for this group.
     */
    public Set getIncludeCodaSet() {
        if (this.includeCodas == null) {
            this.includeCodas = new OrderedSet();
        }
        return this.includeCodas;
    }

    /**
     * Returns an enumeration of include coda patterns for this 
     * group.
     */
    public Enumeration getIncludeCodas() {
        return (new Vector(this.getIncludeCodaSet())).elements();
    }
   
    /**
     * Adds an element
     */
    public void addIncludeCoda(String coda) {
        this.getIncludeCodaSet().add(coda);

    }
   
    /**
     * Removes an element 
     */
    public void removeIncludeCoda(String coda) {
        this.getIncludeCodaSet().remove(coda);

    }

    /**
     * elIgnored
     */
    public void setElIgnored(boolean value) {
        elIgnored = value;
    }

    /**
     */
    public boolean isElIgnored() {
        return elIgnored;
    }
    
    /**
     * enable/disable scripting
     */
    public void setScriptingInvalid(boolean value) {
        scriptingInvalid = value;
    }

    /**
     * return if scripting is enabled.
     */
    public boolean isScriptingInvalid() {
        return scriptingInvalid;
    }

    /**
     * enable/disable xml 
     */
    public void setIsXml(Boolean value) {
        isXml = value;
    }
    
    public Boolean getIsXml() {
        return isXml;
    }
    
    /**
     * enable/disable deferredSyntaxAllowedAsLiteral
     */
    public void setDeferredSyntaxAllowedAsLiteral(boolean value) {
        deferredSyntaxAllowedAsLiteral = value;
    }

    /**
     * return if is deferredSyntaxAllowedAsLiteral.
     */
    public boolean isDeferredSyntaxAllowedAsLiteral() {
        return deferredSyntaxAllowedAsLiteral;
    }

    /**
     * enable/disable trimDirectiveWhitespaces
     */
    public void setTrimDirectiveWhitespaces(boolean value) {
        trimDirectiveWhitespaces = value;
    }

    /**
     * return if is trimDirectiveWhitespaces.
     */
    public boolean isTrimDirectiveWhitespaces() {
        return trimDirectiveWhitespaces;
    }

    
    /**
     * get display name.
     */
    public String getDisplayName() {
        // bug#4745178  other code requires the
        // display name to be localized.
        return super.getName();
    }

    /**
     * set display name.
     */
    public void setDisplayName(String name) {
        // bug#4745178  other code requires the
        // display name to be localized.
        super.setName(name);
    }

    public String getPageEncoding() {
	return pageEncoding;
    }

    public void setPageEncoding(String encoding) {
	pageEncoding = encoding;
    }

    /**
     * get defaultContentType
     */
    public String getDefaultContentType() {
        return defaultContentType;
    }

    /**
     * set defaultContentType
     */
    public void setDefaultContentType(String defaultContentType) {
        this.defaultContentType = defaultContentType;
    }

    /**
     * get buffer
     */
    public String getBuffer() {
        return buffer;
    }

    /**
     * set buffer
     */
    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    /**
     * check if it is errorOnUndeclaredNamespace
     */
    public boolean isErrorOnUndeclaredNamespace() {
        return errorOnUndeclaredNamespace;
    }

    /**
     * set errorOnUndeclaredNamespace
     */
    public void setErrorOnUndeclaredNamespace(boolean errorOnUndeclaredNamespace) {
        this.errorOnUndeclaredNamespace = errorOnUndeclaredNamespace;
    }

    /**
     * @return a string describing the values I hold
     */
    public void print(StringBuffer toStringBuffer) {
        toStringBuffer.append("\n JspGroupDescriptor");
        toStringBuffer.append( "\n");
        super.print(toStringBuffer);
        toStringBuffer.append( "\n DisplayName:").append(this.getDisplayName());
        toStringBuffer.append( "\n PageEncoding:").append(pageEncoding);
        toStringBuffer.append( "\n El-Ignored:").append(elIgnored);
        toStringBuffer.append( "\n Scripting Invalid:").append(scriptingInvalid);
        toStringBuffer.append( "\n urlPatterns: ").append(urlPatterns);
        toStringBuffer.append( "\n includePreludes: ").append(includePreludes);
        toStringBuffer.append( "\n includeCoda: ").append(includeCodas);
        toStringBuffer.append( "\n Is XML:").append(isXml);
        toStringBuffer.append( "\n DeferredSyntaxAllowedAsLiteral: ").append(deferredSyntaxAllowedAsLiteral);
        toStringBuffer.append( "\n TrimDirectiveWhitespaces:").append(trimDirectiveWhitespaces);
        toStringBuffer.append( "\n defaultContentType: ").append(defaultContentType);
        toStringBuffer.append( "\n buffer: ").append(buffer);
        toStringBuffer.append( "\n errorOnUndeclaredNamespace: ").append(errorOnUndeclaredNamespace);
    }
}

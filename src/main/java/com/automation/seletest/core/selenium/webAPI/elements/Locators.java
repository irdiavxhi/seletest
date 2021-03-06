/*
This file is part of the Seletest by Papadakis Giannis <gpapadakis84@gmail.com>.

Copyright (c) 2014, Papadakis Giannis <gpapadakis84@gmail.com>
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
      this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.automation.seletest.core.selenium.webAPI.elements;


import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

@SuppressWarnings("unchecked")
public enum Locators {

    //--------------------------------------------------    CoreProperties for Locators --------------------->>>>>>>>>>>>>>>>>
    /** The Constant XPATH. */
    XPATH("xpath"){

        @Override
        public By setLocator(String locator) {
            return By.xpath(findLocatorSubstring(locator));
        }
    },

    /** The Constant CSS. */
    CSS("css"){

        @Override
        public By setLocator(String locator) {
            return By.cssSelector(findLocatorSubstring(locator));
        }
    },

    /** The Constant XPATHEXPR. */
    XPATHEXPR("//"){

        @Override
        public By setLocator(String locator) {
            return By.xpath(locator);
        }
    },


    /** The Constant NAME. */
    NAME("name"){

        @Override
        public By setLocator(String locator) {
            return By.name(findLocatorSubstring(locator));
        }
    },


    /** The Constant LINK. */
    LINK("link"){

        @Override
        public By setLocator(String locator) {
            return By.linkText(findLocatorSubstring(locator));
        }
    },

    /** The Constant ID. */
    ID("id"){

        @Override
        public By setLocator(String locator) {
            return By.id(findLocatorSubstring(locator));
        }
    },

    /** The Constant TAGNAME. */
    TAGNAME("tagname"){

        @Override
        public By setLocator(String locator) {
            return By.tagName(findLocatorSubstring(locator));
        }
    },

    /** The Constant JQUERY. */
    JQUERY("jquery"){

        @Override
        public By setLocator(String locator) {
            return BySelector.ByJQuery(findLocatorSubstring(locator));
        }
    },

    /** The Constant CLASSNAME. */
    CLASSNAME("className"){

        @Override
        public By setLocator(String locator) {
            return By.className(findLocatorSubstring(locator));
        }
    },

    /** The Constant ANDROIDUIAUTOMATOR. */
    ANDROIDUIAUTOMATOR("androidUIAutomator"){

        @Override
        public MobileBy setLocator(String locator) {
            return (MobileBy) MobileBy.AndroidUIAutomator(findLocatorSubstring(locator));
        }
    },

    /** The Constant IOSUIAUTOMATOR. */
    IOSUIAUTOMATOR("iOSUIAutomator"){

        @Override
        public MobileBy setLocator(String locator) {
            return (MobileBy) MobileBy.IosUIAutomation(findLocatorSubstring(locator));
        }
    },

    /** The Constant ACCESSIBILITYID. */
    ACCESSIBILITYID("accessibilityId"){

        @Override
        public MobileBy setLocator(String locator) {
            return (MobileBy) MobileBy.AccessibilityId(findLocatorSubstring(locator));
        }
    },
   ;
    public abstract <T extends By> T setLocator(String locator);

    /**The value of enum type*/
    private String value;

    private Locators(final String locator) {
        this.value = locator;

    }

    synchronized static String findLocatorSubstring(String locator){
        return locator.substring(locator.indexOf('=')+1);
    }

    /**Get locator by value
     *
     * @return locator
     */
    public String getLocator() {
        return value;
    }

    /**
     * Return enum for given value
     * @param locator String lcoator to use
     * @return Locators enum object
     */
    static synchronized public Locators findByLocator(String locator) {
        if (locator != null) {
            for (Locators locatorUsed : Locators.values()) {
                if (locator.startsWith(locatorUsed.getLocator())) {
                    return locatorUsed;
                }
            }
        }

        return null;
    }



}

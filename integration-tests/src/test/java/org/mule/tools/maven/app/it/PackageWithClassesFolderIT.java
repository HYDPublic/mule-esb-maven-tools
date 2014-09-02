/**
 * Mule ESB Maven Tools
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.tools.maven.app.it;

import java.io.File;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PackageWithClassesFolderIT extends AbstractMavenIT {

    @Override
    protected String getArtifactVersion() {
        return "1.0";
    }

    @Override
    protected String getArtifactId() {
        return "project-with-plain-classes";
    }

    @Override
    protected String getGroupId() {
        return "org.mule.maven.tools.it";
    }

    @Override
    protected File getRoot() {
        return new File("target/integration-tests/" + getArtifactId());
    }

    @Override
    protected void verify() throws Exception {
        String pathToClasses = String.format("target/integration-tests/%1s/target/classes", getArtifactId());
        File classesFolder = (new File(pathToClasses)).getAbsoluteFile();
        assertFileExists(classesFolder);
        assertTrue(classesFolder.isDirectory());
    }
}


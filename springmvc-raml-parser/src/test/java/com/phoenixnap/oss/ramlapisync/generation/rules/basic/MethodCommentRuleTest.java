package com.phoenixnap.oss.ramlapisync.generation.rules.basic;

import com.phoenixnap.oss.ramlapisync.generation.rules.AbstractControllerRuleTestBase;
import com.sun.codemodel.*;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author armin.weisser
 * @since 0.4.1
 */
public class MethodCommentRuleTest extends AbstractControllerRuleTestBase {

    private MethodCommentRule rule = new MethodCommentRule();

    @Test
    public void applyRule_shouldCreate_validMethodComment() throws JClassAlreadyExistsException {

        JDefinedClass jClass = jCodeModel.rootPackage()._class("TestController");
        JMethod jMethod = jClass.method(JMod.PUBLIC, ResponseEntity.class, "getBaseById");
        JDocComment jDocComment = rule.apply(getEndpointMetadata(2), jMethod);

        assertThat(serializeModel(), containsString("* Get base entity by ID"));
    }

}

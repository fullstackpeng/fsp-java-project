package com.fullstackpeng.fspjavaproject.infrastructure.gen;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.blazebit.persistence.CriteriaBuilderFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.javapoet.ClassName;
import org.springframework.javapoet.JavaFile;
import org.springframework.javapoet.MethodSpec;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

/**
 * @project_name: fsp-java-project
 * @name: GenCode
 * @description: 生成代码
 * @author: fullstackpeng
 * @create: 2024-07-06 11:50
 **/
public class GenCode {
    public static void main(String[] args) throws IOException {
        servicegen();
    }


    public static void servicegen() throws IOException {
        String className = "Test";
        String packageName = "com.fullstackpeng.fspjavaproject.infrastructure.gen";
        String path = "/Users/peng/Documents/project/fsp-java-project/src/main/java";
        File file = new File(path);
        ClassName repository = ClassName.get(packageName, className + "Repository");
        ClassName entity = ClassName.get(packageName, className);
        ClassName addDTO = ClassName.get(packageName + ".dto", className + "AddDTO");
        ClassName editDTO = ClassName.get(packageName + ".dto", className + "EditDTO");
        ClassName listDTO = ClassName.get(packageName + ".dto", className + "ListDTO");
        ClassName pageDTO = ClassName.get(packageName + ".dto", className + "PageDTO");
        ClassName addVO = ClassName.get(packageName + ".vo", className + "AddVO");
        ClassName editVO = ClassName.get(packageName + ".vo", className + "EditVO");
        ClassName deleteVO = ClassName.get(packageName + ".vo", className + "DeleteVO");
        ClassName getVO = ClassName.get(packageName + ".vo", className + "GetVO");
        ClassName listVO = ClassName.get(packageName + ".vo", className + "ListVO");
        ClassName pageVO = ClassName.get(packageName + ".vo", className + "PageVO");
        MethodSpec add = MethodSpec.methodBuilder("add")
                .addModifiers(Modifier.PUBLIC)
                .returns(addVO)
                .addParameter(addDTO, StrUtil.lowerFirst(className) + "AddDTO")
//                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .addStatement(className + " " + StrUtil.lowerFirst(className) + " = $T.copyProperties(" + StrUtil.lowerFirst(className) + "AddDTO" + ", $T.class)", BeanUtil.class, entity)
                .addStatement(StrUtil.lowerFirst(className) + " = " + StrUtil.lowerFirst(className) + "Repository.save(" + StrUtil.lowerFirst(className) + ")")
                .addStatement("return $T.copyProperties(" + StrUtil.lowerFirst(className) + ", $T.class)", BeanUtil.class, addVO)
                .build();
        MethodSpec edit = MethodSpec.methodBuilder("edit")
                .addModifiers(Modifier.PUBLIC)
                .returns(editVO)
                .addParameter(editDTO, StrUtil.lowerFirst(className) + "editDTO")
                .addStatement(className + " " + StrUtil.lowerFirst(className) + " = " + StrUtil.lowerFirst(className) + "Repository.findById()", BeanUtil.class, entity)
                .addStatement(className + " " + StrUtil.lowerFirst(className) + " = $T.copyProperties(" + StrUtil.lowerFirst(className) + "AddDTO" + ", $T.class)", BeanUtil.class, entity)
                .addStatement(StrUtil.lowerFirst(className) + " = " + StrUtil.lowerFirst(className) + "Repository.save(" + StrUtil.lowerFirst(className) + ")")
                .addStatement("return $T.copyProperties(" + StrUtil.lowerFirst(className) + ", $T.class)", BeanUtil.class, addVO)
                .build();
        TypeSpec service = TypeSpec.classBuilder(className + "Service")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Service.class)
                .addAnnotation(RequiredArgsConstructor.class)
                .addField(EntityManager.class, "entityManager", Modifier.PRIVATE, Modifier.FINAL)
                .addField(CriteriaBuilderFactory.class, "criteriaBuilderFactory", Modifier.PRIVATE, Modifier.FINAL)
                .addField(repository, StrUtil.lowerFirst(className) + "Repository", Modifier.PRIVATE, Modifier.FINAL)
                .addMethod(add)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, service)
                .build();

        javaFile.writeTo(file);
    }
}

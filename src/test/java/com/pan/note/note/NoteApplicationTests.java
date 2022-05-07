package com.pan.note.note;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;


import java.util.Collections;


class NoteApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void generator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/personalnote?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT", "root", "a123456")
                .globalConfig(builder -> {
                    builder.author("Pan") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\VueProjects\\generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.pan.note") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\VueProjects\\generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("userschools");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}

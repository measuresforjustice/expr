#!/bin/sh
rm -rf src/main/java/io/mfj/expr/antlr4
cd src/main/resources/io/mfj/expr
antlr4 -package io.mfj.expr.antlr4 -o ~/code/textricator/expr/src/main/java/io/mfj/expr/antlr4/ -visitor Expr.g4

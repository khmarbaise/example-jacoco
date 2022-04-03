package com.soebes.example.jacoco;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ClassWithStaticTest {

  @Test
  void static_method_without_mock() {
    assertThat(ClassWithStatic.staticMethod(5)).isFalse();
    assertThat(ClassWithStatic.staticMethod(10)).isTrue();
  }

  @Test
  void static_method_without_parameters() {
    assertThat(ClassWithStatic.staticMethodWithoutParameters()).isEqualTo("ThisIsIt");
  }

  @Test
  void mocking_method_without_parameters() {
    try (MockedStatic<ClassWithStatic> mockStatic = mockStatic(ClassWithStatic.class)) {
      mockStatic.when(ClassWithStatic::staticMethodWithoutParameters).thenReturn("ANewValue");
      assertThat(ClassWithStatic.staticMethodWithoutParameters()).isEqualTo("ANewValue");
      mockStatic.verify(ClassWithStatic::staticMethodWithoutParameters);
    }
  }

  @Test
  void mocking_method_with_parameters() {
    try (MockedStatic<ClassWithStatic> mockStatic = mockStatic(ClassWithStatic.class)) {
      mockStatic.when(() -> ClassWithStatic.staticMethod(5)).thenReturn(true);
      mockStatic.when(() -> ClassWithStatic.staticMethod(10)).thenReturn(false);
      assertThat(ClassWithStatic.staticMethod(5)).isTrue();
      assertThat(ClassWithStatic.staticMethod(10)).isFalse();
      mockStatic.verify(() -> ClassWithStatic.staticMethod(anyInt()), times(2));
    }
  }
}
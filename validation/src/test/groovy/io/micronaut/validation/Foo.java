/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.validation;

import io.micronaut.context.annotation.Executable;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
@Validated
@Singleton
public class Foo {

    public String testMe(@Digits(integer = 3, fraction = 2) String number) {
        return '$' + number;
    }

    @NotNull
    public String notNull() {
        return null;
    }

    @NotNull
    public Bar notNullBar() {
        return null;
    }

    @Valid
    public Bar cascadeValidateReturnValue() {
        return new Bar();
    }

    public List<@Valid Bar> validateReturnList() {
        return Collections.singletonList(new Bar());
    }

    public Map<String, @Valid Bar> validateMap() {
        return Collections.singletonMap("barObj", new Bar());
    }
}

@Introspected
class Bar {

    @NotNull
    private String prop;

    @NotNull
    public String getProp() {
        return prop;
    }

    public void setProp(@NotNull String prop) {
        this.prop = prop;
    }
}

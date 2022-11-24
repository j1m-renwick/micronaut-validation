package io.micronaut.validation.validator.map;

import io.micronaut.core.annotation.Introspected;
import javax.validation.Valid;
import java.util.Map;

@Introspected
record Author(
    String name,
    Map<String, @Valid Book> books
) {}

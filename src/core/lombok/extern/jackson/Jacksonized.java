/*
 * Copyright (C) 2020 The Project Lombok Authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok.extern.jackson;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * The {@code @Jacksonized} annotation is an add-on annotation for
 * {@code @}{@link Builder} and {@code @}{@link SuperBuilder}. It automatically
 * configures the generated builder class to be used by Jackson's
 * deserialization. It only has an effect if present at a context where there is
 * also a {@code @Builder} or a {@code @SuperBuilder}; a warning is emitted
 * otherwise.
 * <p>
 * In particular, the annotation does the following:
 * <ul>
 * <li>Configure Jackson to use the builder for deserialization using
 * {@code @JsonDeserialize(builder=Foobar.FoobarBuilder[Impl].class)}
 * on the class (where <em>Foobar</em> is the name of the annotated class).</li>
 * <li>Copy Jackson-related configuration annotations (like
 * {@code @JsonIgnoreProperties}) from the class to the builder class. This is
 * necessary so that Jackson recognizes them when using the builder.</li>
 * <li>Insert {@code @JsonPOJOBuilder(withPrefix="")} on the generated builder
 * class to override Jackson's default prefix "with". If you configured a
 * different prefix in lombok using {@code setterPrefix}, this value is used. If
 * you changed the name of the {@code build()} method using using
 * {@code buildMethodName}, this is also made known to Jackson.</li>
 * <li>For {@code @SuperBuilder}, make the builder implementation class
 * package-private.</li>
 * </ul>
 * This annotation does <em>not</em> change the behavior of the generated builder.
 * A {@code @Jacksonized} {@code @SuperBuilder} remains fully compatible to
 * regular {@code @SuperBuilder}s.
 */
@Target({TYPE, METHOD, CONSTRUCTOR})
@Retention(SOURCE)
public @interface Jacksonized {
}

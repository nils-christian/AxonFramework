/*
 * Copyright (c) 2010-2022. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.tracing;

import org.axonframework.messaging.Message;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public interface AxonSpan {

    AxonSpan withMessageAsParent(Message<?> message);

    AxonSpan withSpanKind(AxonSpanKind spanKind);

    AxonSpan start();

    void end();

    AxonSpan recordException(Throwable t);

    <T> T wrap(Supplier<T> supplier);

    void run(Runnable runnable);

    Runnable wrap(Runnable runnable);

    <T> T wrapCallable(Callable<T> callable) throws Exception;
}

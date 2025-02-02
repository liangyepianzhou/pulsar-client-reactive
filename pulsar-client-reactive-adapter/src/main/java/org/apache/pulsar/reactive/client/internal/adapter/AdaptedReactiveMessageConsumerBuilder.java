/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pulsar.reactive.client.internal.adapter;

import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.reactive.client.api.ImmutableReactiveMessageConsumerSpec;
import org.apache.pulsar.reactive.client.api.MutableReactiveMessageConsumerSpec;
import org.apache.pulsar.reactive.client.api.ReactiveMessageConsumer;
import org.apache.pulsar.reactive.client.api.ReactiveMessageConsumerBuilder;
import org.apache.pulsar.reactive.client.api.ReactiveMessageConsumerSpec;

class AdaptedReactiveMessageConsumerBuilder<T> implements ReactiveMessageConsumerBuilder<T> {

	private final Schema<T> schema;

	private final ReactiveConsumerAdapterFactory reactiveConsumerAdapterFactory;

	private final MutableReactiveMessageConsumerSpec consumerSpec = new MutableReactiveMessageConsumerSpec();

	AdaptedReactiveMessageConsumerBuilder(Schema<T> schema,
			ReactiveConsumerAdapterFactory reactiveConsumerAdapterFactory) {
		this.schema = schema;
		this.reactiveConsumerAdapterFactory = reactiveConsumerAdapterFactory;
	}

	@Override
	public ReactiveMessageConsumerSpec toImmutableSpec() {
		return new ImmutableReactiveMessageConsumerSpec(this.consumerSpec);
	}

	@Override
	public MutableReactiveMessageConsumerSpec getMutableSpec() {
		return this.consumerSpec;
	}

	@Override
	public ReactiveMessageConsumer<T> build() {
		return new AdaptedReactiveMessageConsumer<T>(this.reactiveConsumerAdapterFactory, this.schema,
				toImmutableSpec());
	}

}

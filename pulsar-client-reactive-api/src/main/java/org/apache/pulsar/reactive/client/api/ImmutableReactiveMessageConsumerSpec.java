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

package org.apache.pulsar.reactive.client.api;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.pulsar.client.api.ConsumerCryptoFailureAction;
import org.apache.pulsar.client.api.CryptoKeyReader;
import org.apache.pulsar.client.api.DeadLetterPolicy;
import org.apache.pulsar.client.api.KeySharedPolicy;
import org.apache.pulsar.client.api.RegexSubscriptionMode;
import org.apache.pulsar.client.api.SubscriptionMode;
import org.apache.pulsar.client.api.SubscriptionType;
import reactor.core.scheduler.Scheduler;

public class ImmutableReactiveMessageConsumerSpec implements ReactiveMessageConsumerSpec {

	private final List<String> topicNames;

	private final Pattern topicsPattern;

	private final RegexSubscriptionMode topicsPatternSubscriptionMode;

	private final Duration topicsPatternAutoDiscoveryPeriod;

	private final String subscriptionName;

	private final SubscriptionMode subscriptionMode;

	private final SubscriptionType subscriptionType;

	private final KeySharedPolicy keySharedPolicy;

	private final Boolean replicateSubscriptionState;

	private final Map<String, String> subscriptionProperties;

	private final String consumerName;

	private final Map<String, String> properties;

	private final Integer priorityLevel;

	private final Boolean readCompacted;

	private final Boolean batchIndexAckEnabled;

	private final Duration ackTimeout;

	private final Duration ackTimeoutTickTime;

	private final Duration acknowledgementsGroupTime;

	private final Boolean acknowledgeAsynchronously;

	private final Scheduler acknowledgeScheduler;

	private final Duration negativeAckRedeliveryDelay;

	private final DeadLetterPolicy deadLetterPolicy;

	private final Boolean retryLetterTopicEnable;

	private final Integer receiverQueueSize;

	private final Integer maxTotalReceiverQueueSizeAcrossPartitions;

	private final Boolean autoUpdatePartitions;

	private final Duration autoUpdatePartitionsInterval;

	private final CryptoKeyReader cryptoKeyReader;

	private final ConsumerCryptoFailureAction cryptoFailureAction;

	private final Integer maxPendingChunkedMessage;

	private final Boolean autoAckOldestChunkedMessageOnQueueFull;

	private final Duration expireTimeOfIncompleteChunkedMessage;

	public ImmutableReactiveMessageConsumerSpec(ReactiveMessageConsumerSpec consumerSpec) {
		this.topicNames = (consumerSpec.getTopicNames() != null && !consumerSpec.getTopicNames().isEmpty())
				? Collections.unmodifiableList(new ArrayList<>(consumerSpec.getTopicNames())) : null;

		this.topicsPattern = consumerSpec.getTopicsPattern();

		this.topicsPatternSubscriptionMode = consumerSpec.getTopicsPatternSubscriptionMode();

		this.topicsPatternAutoDiscoveryPeriod = consumerSpec.getTopicsPatternAutoDiscoveryPeriod();

		this.subscriptionName = consumerSpec.getSubscriptionName();

		this.subscriptionMode = consumerSpec.getSubscriptionMode();

		this.subscriptionType = consumerSpec.getSubscriptionType();

		this.keySharedPolicy = consumerSpec.getKeySharedPolicy();

		this.replicateSubscriptionState = consumerSpec.getReplicateSubscriptionState();

		this.subscriptionProperties = (consumerSpec.getSubscriptionProperties() != null
				&& !consumerSpec.getSubscriptionProperties().isEmpty())
						? Collections.unmodifiableMap(new LinkedHashMap<>(consumerSpec.getSubscriptionProperties()))
						: null;

		this.consumerName = consumerSpec.getConsumerName();

		this.properties = (consumerSpec.getProperties() != null && !consumerSpec.getProperties().isEmpty())
				? Collections.unmodifiableMap(new LinkedHashMap<>(consumerSpec.getProperties())) : null;

		this.priorityLevel = consumerSpec.getPriorityLevel();

		this.readCompacted = consumerSpec.getReadCompacted();

		this.batchIndexAckEnabled = consumerSpec.getBatchIndexAckEnabled();

		this.ackTimeout = consumerSpec.getAckTimeout();

		this.ackTimeoutTickTime = consumerSpec.getAckTimeoutTickTime();

		this.acknowledgementsGroupTime = consumerSpec.getAcknowledgementsGroupTime();

		this.acknowledgeAsynchronously = consumerSpec.getAcknowledgeAsynchronously();
		this.acknowledgeScheduler = consumerSpec.getAcknowledgeScheduler();
		this.negativeAckRedeliveryDelay = consumerSpec.getNegativeAckRedeliveryDelay();

		this.deadLetterPolicy = consumerSpec.getDeadLetterPolicy();

		this.retryLetterTopicEnable = consumerSpec.getRetryLetterTopicEnable();

		this.receiverQueueSize = consumerSpec.getReceiverQueueSize();

		this.maxTotalReceiverQueueSizeAcrossPartitions = consumerSpec.getMaxTotalReceiverQueueSizeAcrossPartitions();

		this.autoUpdatePartitions = consumerSpec.getAutoUpdatePartitions();

		this.autoUpdatePartitionsInterval = consumerSpec.getAutoUpdatePartitionsInterval();

		this.cryptoKeyReader = consumerSpec.getCryptoKeyReader();

		this.cryptoFailureAction = consumerSpec.getCryptoFailureAction();

		this.maxPendingChunkedMessage = consumerSpec.getMaxPendingChunkedMessage();

		this.autoAckOldestChunkedMessageOnQueueFull = consumerSpec.getAutoAckOldestChunkedMessageOnQueueFull();

		this.expireTimeOfIncompleteChunkedMessage = consumerSpec.getExpireTimeOfIncompleteChunkedMessage();
	}

	public List<String> getTopicNames() {
		return this.topicNames;
	}

	public Pattern getTopicsPattern() {
		return this.topicsPattern;
	}

	public RegexSubscriptionMode getTopicsPatternSubscriptionMode() {
		return this.topicsPatternSubscriptionMode;
	}

	public Duration getTopicsPatternAutoDiscoveryPeriod() {
		return this.topicsPatternAutoDiscoveryPeriod;
	}

	public String getSubscriptionName() {
		return this.subscriptionName;
	}

	public SubscriptionMode getSubscriptionMode() {
		return this.subscriptionMode;
	}

	public SubscriptionType getSubscriptionType() {
		return this.subscriptionType;
	}

	public KeySharedPolicy getKeySharedPolicy() {
		return this.keySharedPolicy;
	}

	public Boolean getReplicateSubscriptionState() {
		return this.replicateSubscriptionState;
	}

	public Map<String, String> getSubscriptionProperties() {
		return this.subscriptionProperties;
	}

	public String getConsumerName() {
		return this.consumerName;
	}

	public Map<String, String> getProperties() {
		return this.properties;
	}

	public Integer getPriorityLevel() {
		return this.priorityLevel;
	}

	public Boolean getReadCompacted() {
		return this.readCompacted;
	}

	public Boolean getBatchIndexAckEnabled() {
		return this.batchIndexAckEnabled;
	}

	public Duration getAckTimeout() {
		return this.ackTimeout;
	}

	public Duration getAckTimeoutTickTime() {
		return this.ackTimeoutTickTime;
	}

	public Duration getAcknowledgementsGroupTime() {
		return this.acknowledgementsGroupTime;
	}

	public Boolean getAcknowledgeAsynchronously() {
		return this.acknowledgeAsynchronously;
	}

	public Scheduler getAcknowledgeScheduler() {
		return this.acknowledgeScheduler;
	}

	public Duration getNegativeAckRedeliveryDelay() {
		return this.negativeAckRedeliveryDelay;
	}

	public DeadLetterPolicy getDeadLetterPolicy() {
		return this.deadLetterPolicy;
	}

	public Boolean getRetryLetterTopicEnable() {
		return this.retryLetterTopicEnable;
	}

	public Integer getReceiverQueueSize() {
		return this.receiverQueueSize;
	}

	public Integer getMaxTotalReceiverQueueSizeAcrossPartitions() {
		return this.maxTotalReceiverQueueSizeAcrossPartitions;
	}

	public Boolean getAutoUpdatePartitions() {
		return this.autoUpdatePartitions;
	}

	public Duration getAutoUpdatePartitionsInterval() {
		return this.autoUpdatePartitionsInterval;
	}

	public CryptoKeyReader getCryptoKeyReader() {
		return this.cryptoKeyReader;
	}

	public ConsumerCryptoFailureAction getCryptoFailureAction() {
		return this.cryptoFailureAction;
	}

	public Integer getMaxPendingChunkedMessage() {
		return this.maxPendingChunkedMessage;
	}

	public Boolean getAutoAckOldestChunkedMessageOnQueueFull() {
		return this.autoAckOldestChunkedMessageOnQueueFull;
	}

	public Duration getExpireTimeOfIncompleteChunkedMessage() {
		return this.expireTimeOfIncompleteChunkedMessage;
	}

}

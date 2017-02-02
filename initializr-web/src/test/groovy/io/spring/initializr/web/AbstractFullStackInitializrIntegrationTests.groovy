/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.initializr.web

import org.junit.runner.RunWith

import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

/**
 * @author Stephane Nicoll
 * @author Dave Syer
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class, webEnvironment = RANDOM_PORT)
abstract class AbstractFullStackInitializrIntegrationTests
		extends AbstractInitializrIntegrationTests {

	@LocalServerPort
	int port

	String host = "localhost"

	String createUrl(String context) {
		"http://${host}:${port}" + (context.startsWith('/') ? context : '/' + context)
	}

}

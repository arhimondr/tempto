/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teradata.tempto.examples;

import com.google.inject.Inject;
import com.teradata.tempto.process.CliProcess;
import com.teradata.tempto.ssh.SshClient;

import javax.inject.Named;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

public class ExampleSshClientUsage
{
    private final SshClient sshClient;

    @Inject
    public ExampleSshClientUsage(@Named("td_express") SshClient sshClient) {
        this.sshClient = sshClient;
    }

    public void execute(String command) {
        try (CliProcess cliProcess = sshClient.execute(command)) {
            // Within this method std::out,std::err will both be printed to the log
            cliProcess.waitForWithTimeoutAndKill(Duration.ofMinutes(10));
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Execution was interrupted", e);
        }
    }

    public void upload(String what, String where) {
        sshClient.upload(Paths.get(what), where);
    }
}

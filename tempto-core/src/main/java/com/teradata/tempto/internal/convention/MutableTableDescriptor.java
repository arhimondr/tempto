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
package com.teradata.tempto.internal.convention;

import com.teradata.tempto.fulfillment.table.MutableTableRequirement.State;

import static com.google.common.base.Preconditions.checkNotNull;

public final class MutableTableDescriptor
{
    public final String tableDefinitionName;
    public final State state;
    public final TableName name;

    MutableTableDescriptor(String tableDefinitionName, State state, TableName name)
    {
        this.tableDefinitionName = checkNotNull(tableDefinitionName);
        this.state = checkNotNull(state);
        this.name = checkNotNull(name);
    }
}

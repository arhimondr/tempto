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

package com.teradata.tempto.fulfillment.table;

import com.teradata.tempto.internal.fulfillment.table.DatabaseTableInstanceMap;

import java.util.Map;

import static com.teradata.tempto.context.ThreadLocalTestContextHolder.testContext;

public class MutableTablesState
        extends TablesState
{

    public static MutableTablesState mutableTablesState()
    {
        return testContext().getDependency(MutableTablesState.class);
    }

    public MutableTablesState(Map<String, DatabaseTableInstanceMap> databaseTableInstanceMap)
    {
        super(databaseTableInstanceMap, "mutable table");
    }
}

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

import com.teradata.tempto.Requirement;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public abstract class TableRequirement<T extends TableRequirement>
        implements Requirement
{

    private final TableDefinition tableDefinition;
    private final DatabaseSelectionContext databaseSelectionContext;

    protected TableRequirement(TableDefinition tableDefinition, DatabaseSelectionContext databaseSelectionContext)
    {
        this.tableDefinition = requireNonNull(tableDefinition, "tableDefinition is null");
        this.databaseSelectionContext = requireNonNull(databaseSelectionContext, "databaseSelectionContext is null");
    }

    public TableDefinition getTableDefinition()
    {
        return tableDefinition;
    }

    public DatabaseSelectionContext getDatabaseSelectionContext()
    {
        return databaseSelectionContext;
    }

    public abstract T copyWithDatabase(String databaseName);

    @Override
    public boolean equals(Object o)
    {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode()
    {
        return reflectionHashCode(this);
    }
}

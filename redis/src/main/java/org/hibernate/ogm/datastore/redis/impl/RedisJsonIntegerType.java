package org.hibernate.ogm.datastore.redis.impl;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.ogm.type.descriptor.impl.IntegerMappedGridTypeDescriptor;
import org.hibernate.ogm.type.impl.AbstractGenericBasicType;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;

/**
 * Type for storing {@code long}s in Redis JSON. The JSON parser uses {@link java.math.BigDecimal}s to deserialize integer data
 * types.
 *
 * @author Mark Paluch
 */
public class RedisJsonIntegerType extends AbstractGenericBasicType<Integer> {

	public static final RedisJsonIntegerType INSTANCE = new RedisJsonIntegerType();

	public RedisJsonIntegerType() {
		super( IntegerMappedGridTypeDescriptor.INSTANCE, IntegerTypeDescriptor.INSTANCE );
	}

	@Override
	public String getName() {
		return "redis_integer";
	}

	@Override
	public int getColumnSpan(Mapping mapping) throws MappingException {
		return 1;
	}
}
package org.coinjema.nontest;

import org.coinjema.context.ContextOriented;

public aspect MakeContextOriented {
	declare parents : UnAnnotated implements ContextOriented;

}

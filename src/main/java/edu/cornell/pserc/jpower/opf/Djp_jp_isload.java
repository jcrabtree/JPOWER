/*
 * Copyright (C) 1996-2010 Power System Engineering Research Center
 * Copyright (C) 2010-2011 Richard Lincoln
 *
 * JPOWER is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * JPOWER is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JPOWER. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.cornell.pserc.jpower.opf;

import cern.colt.matrix.tint.IntMatrix1D;

import static edu.emory.mathcs.utils.Utils.ifunc;
import static edu.emory.mathcs.utils.Utils.dfunc;
import static edu.emory.mathcs.utils.Utils.intm;

import edu.cornell.pserc.jpower.jpc.Gen;

/**
 * Checks for dispatchable loads.
 *
 * @author Ray Zimmerman
 * @author Richard Lincoln
 *
 */
public class Djp_jp_isload {

	/**
	 * Returns a column vector of 1's and 0's. The 1's
	 * correspond to rows of the GEN matrix which represent dispatchable loads.
	 * The current test is Pmin < 0 AND Pmax == 0.
	 * This may need to be revised to allow sensible specification
	 * of both elastic demand and pumped storage units.
	 *
	 * @param gen
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static IntMatrix1D isload(Gen gen) {

		return intm( gen.Pmin.copy().assign(dfunc.less(0)) ).assign(intm( gen.Pmax.copy().assign(dfunc.equals(0)) ), ifunc.and);
	}

}

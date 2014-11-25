/*
 * Copyright 2009-2014 DigitalGlobe, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package org.mrgeo.mapalgebra;

import java.util.Vector;

import org.mrgeo.mapalgebra.parser.ParserAdapter;
import org.mrgeo.mapalgebra.parser.ParserNode;
import org.mrgeo.opimage.RawComparatorDescriptor;

public class RawComparatorMapOp extends RenderedImageMapOp
{
  public static String[] register()
  {
    return new String[] { "<",
        "lt",
        "<=",
        "le",
        "lte",
        ">",
        "gt",
        ">=",
        "gte",
        "ge",
        "==",
        "eq",
        "!=",
        "^=",
        "<>",
        "ne",
        "&&",
        "&",
        "and",
        "||",
        "|",
        "or",
        "xor"};
  }

  public RawComparatorMapOp()
  {
    _factory = new RawComparatorDescriptor();
  }

  @Override
  public Vector<ParserNode> processChildren(final Vector<ParserNode> children, final ParserAdapter parser)
  {
    Vector<ParserNode> result = new Vector<ParserNode>();
    if (children.size() != 2)
    {
      throw new IllegalArgumentException(getFunctionName() + " takes two raster arguments");
    }
    result.add(children.get(0));
    result.add(children.get(1));
    return result;
  }

  @Override
  public String toString()
  {
    return getFunctionName() + "()";
  }

  @Override
  public boolean includeFunctionNameInParameters()
  {
    return true;
  }
}

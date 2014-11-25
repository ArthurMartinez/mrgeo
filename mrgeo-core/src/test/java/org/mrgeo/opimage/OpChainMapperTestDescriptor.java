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

package org.mrgeo.opimage;

import javax.media.jai.JAI;
import javax.media.jai.OperationDescriptorImpl;
import javax.media.jai.registry.RenderedRegistryMode;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.awt.image.renderable.RenderedImageFactory;

/**
 * OpImage descriptor for testing
 */
public class
    OpChainMapperTestDescriptor extends OperationDescriptorImpl implements RenderedImageFactory
{
  private static final long serialVersionUID = 1L;
  public final static int COLOR_SCALE = 0;

  public static RenderedImage create(RenderedImage src1)
  {
    ParameterBlock paramBlock = (new ParameterBlock()).addSource(src1);
    return JAI.create(OpChainMapperTestDescriptor.class.getName(), paramBlock, null);
  }

  public OpChainMapperTestDescriptor()
  {
    // I realize this formatting is horrendous, but Java won't let me assign
    // variables before
    // calling super.
    super(new String[][] { { "GlobalName", OpChainMapperTestDescriptor.class.getName() },
        { "LocalName", OpChainMapperTestDescriptor.class.getName() }, { "Vendor", "com.spadac" },
        { "Description", "" }, { "DocURL", "http://www.spadac.com/" }, { "Version", "1.0" } },
        new String[] { RenderedRegistryMode.MODE_NAME }, 0, new String[] { }, new Class[] { },
        new Object[] { }, null);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * java.awt.image.renderable.RenderedImageFactory#create(java.awt.image.renderable
   * .ParameterBlock, java.awt.RenderingHints)
   */
  @Override
  public RenderedImage create(ParameterBlock paramBlock, RenderingHints hints)
  {
    return OpChainMapperTestOpImage.create(paramBlock.getRenderedSource(0));
  }
}

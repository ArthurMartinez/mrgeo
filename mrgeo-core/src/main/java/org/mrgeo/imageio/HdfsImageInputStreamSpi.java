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

package org.mrgeo.imageio;

import org.apache.hadoop.fs.FSDataInputStream;

import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class HdfsImageInputStreamSpi extends ImageInputStreamSpi
{


  @Override
  public boolean canUseCacheFile()
  {
    return false;
  }

  @Override
  public ImageInputStream createInputStreamInstance(final Object input) throws IOException
  {
    return createInputStreamInstance(input, false, null);
  }

  @Override
  public ImageInputStream createInputStreamInstance(final Object input, final boolean useCache,
    final File cacheDir) throws IOException
  {
    if (input instanceof FSDataInputStream)
    {
      final HdfsImageInputStream stream = new HdfsImageInputStream((FSDataInputStream) input);
      return stream;
    }

    throw new IOException(
      "Error creating input image stream, expecting FSDataInputStream, but got " +
        Object.class.getName());
  }

  @Override
  public String getDescription(final Locale locale)
  {
    return "Service provider that instanciates a FSImageInputStream from a FSDataInputStream";
  }

  @Override
  public Class<?> getInputClass()
  {
    return FSDataInputStream.class;
  }

  @Override
  public boolean needsCacheFile()
  {
    return false;
  }

}
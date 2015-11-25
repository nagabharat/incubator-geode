/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pivotal.jvsd.fx;

import java.nio.MappedByteBuffer;
import java.util.Observable;
import java.util.Observer;

public class VsdSeries  {
  // TODO concurrency
  
  private MappedByteBuffer buffer = null;
  
  private int length = 0;
  
  
  
  
  public void addData(long time, double value) {
    if (buffer.remaining() < 8) {
      expandBuffer();
    }
    
    buffer.putLong(time);
    buffer.putDouble(value);
    length++;
    
    // TODO notify change
  }

  public int getLength() {
    return length;
  }

  private void expandBuffer() {
    // TODO Auto-generated method stub
    
  }
}
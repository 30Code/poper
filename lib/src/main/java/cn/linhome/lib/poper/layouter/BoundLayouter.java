/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.linhome.lib.poper.layouter;

import cn.linhome.lib.poper.parameter.HeightParameter;
import cn.linhome.lib.poper.parameter.Parameter;
import cn.linhome.lib.poper.parameter.WidthParameter;

public abstract class BoundLayouter extends AbstractLayouter
{
    private final Parameter mParameter;
    private final Bound mBound;

    public BoundLayouter(Bound bound)
    {
        if (bound == null)
        {
            throw new NullPointerException("bound is null");
        }

        mBound = bound;
        if (bound == Bound.Width)
        {
            mParameter = new WidthParameter();
        } else
        {
            mParameter = new HeightParameter();
        }
    }

    @Override
    protected String getDebugTag()
    {
        return super.getDebugTag() + " " + mBound;
    }

    protected final Parameter getParameter()
    {
        return mParameter;
    }

    public enum Bound
    {
        Width,
        Height
    }
}

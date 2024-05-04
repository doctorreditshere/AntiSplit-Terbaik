/*
 *  Copyright (C) 2022 github.com/REAndroid
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reandroid.arsc.coder;

import com.reandroid.arsc.value.ValueType;

public class CoderBoolean extends Coder {

    @Override
    public EncodeResult encode(String text) {
        int value;
        if("true".equals(text)){
            value = 0xffffffff;
        }else if("false".equals(text)){
            value = 0;
        }else {
            return null;
        }
        return new EncodeResult(ValueType.BOOLEAN, value);
    }
    @Override
    public String decode(int data) {
        return data == 0 ? "false" : "true";
    }

    @Override
    public ValueType getValueType() {
        return ValueType.BOOLEAN;
    }
    @Override
    boolean canStartWith(char first) {
        return first == 'f' || first == 't';
    }

    public static final CoderBoolean INS = new CoderBoolean();
}

/*
  * This file is part of HyperCeiler.

  * HyperCeiler is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as
  * published by the Free Software Foundation, either version 3 of the
  * License.

  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.

  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <https://www.gnu.org/licenses/>.

  * Copyright (C) 2023-2025 HyperCeiler Contributions
*/
package com.sevtinge.hyperceiler.hook.module.app;

import com.hchen.database.HookBase;
import com.sevtinge.hyperceiler.hook.module.base.BaseModule;
import com.sevtinge.hyperceiler.hook.module.hook.barrage.AnyBarrage;
import com.sevtinge.hyperceiler.hook.module.hook.barrage.BarrageNotTouchable;
import com.sevtinge.hyperceiler.hook.module.hook.barrage.CustomBarrageLength;
import com.sevtinge.hyperceiler.hook.module.hook.barrage.GlobalBarrage;

@HookBase(targetPackage = "com.xiaomi.barrage")
public class Barrage extends BaseModule {
    @Override
    public void handleLoadPackage() {
        initHook(AnyBarrage.INSTANCE, mPrefsMap.getBoolean("barrage_any_barrage"));
        initHook(BarrageNotTouchable.INSTANCE, mPrefsMap.getBoolean("barrage_not_touchable"));
        initHook(GlobalBarrage.INSTANCE, mPrefsMap.getBoolean("barrage_global_enable"));
        initHook(CustomBarrageLength.INSTANCE, mPrefsMap.getInt("barrage_custom_barrage_length", 36) != 36);
    }
}

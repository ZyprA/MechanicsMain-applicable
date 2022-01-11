package me.deecaad.weaponmechanics.compatibility;

import me.deecaad.core.utils.LogLevel;
import me.deecaad.core.utils.ReflectionUtil;
import me.deecaad.weaponmechanics.WeaponMechanics;
import me.deecaad.weaponmechanics.compatibility.scope.IScopeCompatibility;
import me.deecaad.weaponmechanics.compatibility.scope.Scope_1_13_R2;
import me.deecaad.weaponmechanics.compatibility.shoot.IShootCompatibility;
import me.deecaad.weaponmechanics.compatibility.shoot.Shoot_1_13_R2;

import javax.annotation.Nonnull;

public class v1_13_R2 implements IWeaponCompatibility {

    static {
        if (ReflectionUtil.getMCVersion() != 13) {
            WeaponMechanics.debug.log(
                    LogLevel.ERROR,
                    "Loaded " + v1_13_R2.class + " when not using Minecraft 13",
                    new InternalError()
            );
        }
    }

    private final IScopeCompatibility scopeCompatibility;
    private final IShootCompatibility shootCompatibility;

    public v1_13_R2() {
        this.scopeCompatibility = new Scope_1_13_R2();
        this.shootCompatibility = new Shoot_1_13_R2();
    }

    @Nonnull
    @Override
    public IScopeCompatibility getScopeCompatibility() {
        return scopeCompatibility;
    }

    @Nonnull
    @Override
    public IShootCompatibility getShootCompatibility() {
        return shootCompatibility;
    }
}

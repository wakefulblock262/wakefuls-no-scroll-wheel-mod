package net.wakeful.noScroll.wakefulsNoScrollWheelMod;

import me.contaria.speedrunapi.config.api.SpeedrunConfig;
import me.contaria.speedrunapi.config.api.annotations.Config;

@Config
public class WakefulsNoScrollWheelModConfig implements SpeedrunConfig {

    @Config.Boolean.Default(true)
    public boolean disableScrolling = true;

    public void updateDisableScrollFlag() {
        WakefulsNoScrollWheelMod.disableScroll = this.disableScrolling;
        if (WakefulsNoScrollWheelMod.LOGGER != null) {
            WakefulsNoScrollWheelMod.LOGGER.info("Updated disableScroll flag: {}", this.disableScrolling);
        }
    }

    public void setDisableScrolling(boolean disableScrolling) {
        this.disableScrolling = disableScrolling;
        updateDisableScrollFlag();
    }

    {
        WakefulsNoScrollWheelMod.config = this;
        updateDisableScrollFlag();
    }

    @Override
    public String modID() {
        return "wakefuls-no-scroll-wheel-mod";
    }
}

package sekwah.mods.narutomod.client;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.util.ResourceLocation;
import sekwah.mods.narutomod.common.entity.SkinCallback;

public class SkinFetcher {

    private final MinecraftSessionService sessionService;

    public SkinFetcher(MinecraftSessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void getSkin(GameProfile profile, SkinCallback entity) {
        //GameProfile filledProfile = sessionService.fillProfileProperties(profile, false);
        SkinManager skinmanager = Minecraft.getMinecraft().getSkinManager();

        SkinRequest request = new SkinRequest(entity);
        skinmanager.func_152790_a(profile, request, false);
    }

    public class SkinRequest implements SkinManager.SkinAvailableCallback {

        private final SkinCallback callback;

        public SkinRequest(SkinCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onSkinAvailable(MinecraftProfileTexture.Type type, ResourceLocation location) {
            callback.returnedSkin(type, location);
        }
    }

}

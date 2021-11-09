package utils

import BiliLiverTrickGift.modID
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.utils.GdxRuntimeException


object TextureLoader {
    private val textures = HashMap<String, Texture?>()
    private val logger = logger()

    /**
     * @param textureString - String path to the texture you want to load relative to resources,
     * Example: "theDefaultResources/images/ui/missing_texture.png"
     * @return **com.badlogic.gdx.graphics.Texture** - The texture from the path provided
     */
    fun getTexture(textureString: String): Texture? {
        if (textures[textureString] == null) {
            try {
                loadTexture(textureString)
            } catch (e: GdxRuntimeException) {
                logger.error("Could not find texture: $textureString")
                return getTexture("$modID/images/ui/missing_texture.png")
            }
        }
        return textures[textureString]
    }

    /**
     * Creates an instance of the texture, applies a linear filter to it, and places it in the HashMap
     *
     * @param textureString - String path to the texture you want to load relative to resources,
     * Example: "img/ui/missingtexture.png"
     * @throws GdxRuntimeException
     */
    @Throws(GdxRuntimeException::class)
    private fun loadTexture(textureString: String) {
        logger.info("DefaultMod | Loading Texture: $textureString")
        val texture = Texture(textureString)
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear)
        textures[textureString] = texture
    }
}
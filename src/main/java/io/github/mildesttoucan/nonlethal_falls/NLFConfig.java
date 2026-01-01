package io.github.mildesttoucan.nonlethal_falls;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;

public class NLFConfig extends WrappedConfig {

    @Comment("Whether to keep the mod on!")
    public boolean enabled = true;

    @Comment("Whether the mod should apply to *all* entities (if true overrides the next two options)")
    public boolean allEntitiesImmunity = false;

    @Comment("Whether the mod should apply to players.")
    public boolean playerImmunity = true;

    @Comment("Whether the mod should apply to tameable entities (e.g. wolves/dogs, cats, etc.)")
    public boolean tameableImmunity = true;

    @Comment("How much health to let the entity live on after taking lethal fall damage")
    @Comment("It's strongly recommended to leave this very low, otherwise players might be able to *heal* by jumping to their not-death!")
    public float healthLeft = 1.0F;


}

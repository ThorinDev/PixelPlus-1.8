package com.sirhuntpredator.pixelplus.misc;

import java.io.IOException;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

public class PPAT extends AccessTransformer
{
    public PPAT() throws IOException
    {
        super("PixelPlus_at.cfg");
    }
}
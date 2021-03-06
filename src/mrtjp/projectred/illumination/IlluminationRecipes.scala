package mrtjp.projectred.illumination

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.init
import net.minecraft.item.ItemStack
import mrtjp.projectred.ProjectRedIllumination
import net.minecraft.init.{Blocks, Items}
import mrtjp.projectred.core.PartDefs
import java.lang.{Character => JC}
object IlluminationRecipes
{
    def initRecipes()
    {
        initLighting()
    }

    private def initLighting()
    {
        /** Lamps **/
        for (i <- 0 until 16)
        {
            GameRegistry.addRecipe(new ItemStack(ProjectRedIllumination.blockLamp, 1, i),
                "gIg",
                "gIg",
                "gtg",
                'g':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                't':JC, Items.redstone
            )

            GameRegistry.addRecipe(new ItemStack(ProjectRedIllumination.blockLamp, 1, i+16),
                "gIg",
                "gIg",
                "gtg",
                'g':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                't':JC, Blocks.redstone_torch
            )
        }

        /** Lanterns **/
        for (i <- 0 until 16)
        {
            GameRegistry.addRecipe(LightObjLantern.makeStack(i),
                "PNP",
                "GIG",
                "PRP",
                'P':JC, PartDefs.PLATE.makeStack,
                'N':JC, Items.gold_nugget,
                'G':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'R':JC, Items.redstone
            )
            GameRegistry.addRecipe(LightObjLantern.makeInvStack(i),
                "PNP",
                "GIG",
                "PRP",
                'P':JC, PartDefs.PLATE.makeStack,
                'N':JC, Items.gold_nugget,
                'G':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'R':JC, Blocks.redstone_torch
            )
        }

        /** Buttons **/
        for (i <- 0 until 16)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(ProjectRedIllumination.itemPartIllumarButton, 1, i),
                Blocks.stone_button,
                PartDefs.ILLUMARS.toSeq(i).makeStack,
                PartDefs.ILLUMARS.toSeq(i).makeStack
            )
            GameRegistry.addShapelessRecipe(new ItemStack(ProjectRedIllumination.itemPartIllumarFButton, 1, i),
                new ItemStack(ProjectRedIllumination.itemPartIllumarButton, 1, i),
                Blocks.redstone_torch
            )
        }

        /** Cage Lamps **/
        for (i <- 0 until 16)
        {
            GameRegistry.addRecipe(LightObjCage.makeStack(i),
                "CCC", "CIC", "NPN",
                'C':JC, Blocks.iron_bars,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'N':JC, Items.gold_nugget,
                'P':JC, PartDefs.CONDUCTIVEPLATE.makeStack
            )

            GameRegistry.addRecipe(LightObjCage.makeInvStack(i),
                "CCC", "CIC", "NPN",
                'C':JC, Blocks.iron_bars,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'N':JC, Items.gold_nugget,
                'P':JC, PartDefs.CATHODE.makeStack
            )
        }

        /** Fixtures **/
        for (i <- 0 until 16)
        {
            GameRegistry.addRecipe(LightObjFixture.makeStack(i),
                "ggg", "gIg", "pPp",
                'g':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'p':JC, PartDefs.PLATE.makeStack,
                'P':JC, PartDefs.CONDUCTIVEPLATE.makeStack
            )
            GameRegistry.addRecipe(LightObjFixture.makeInvStack(i),
                "ggg", "gIg", "pPp",
                'g':JC, Blocks.glass_pane,
                'I':JC, PartDefs.ILLUMARS.toSeq(i).makeStack,
                'p':JC, PartDefs.PLATE.makeStack,
                'P':JC, PartDefs.CATHODE.makeStack
            )
        }
    }
}

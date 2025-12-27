package mwchallenger.relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import mwchallenger.character.MyCharacter;

import static mwchallenger.BasicMod.makeID;

public class GrippingChalkRelic extends BaseRelic {
    private static final String NAME = "GrippingChalkRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.STARTER; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.
    public boolean parry_block_check = false;

    public GrippingChalkRelic() {
        super(ID, NAME, MyCharacter.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onPlayerEndTurn(){
        if (AbstractDungeon.player.currentBlock > 0) {
            parry_block_check = true;}
    }
    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if(parry_block_check & AbstractDungeon.player.currentBlock == 0){
            addToBot(new DrawCardAction(1));
        }
        parry_block_check = false;
        return damageAmount;
    }
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }


}

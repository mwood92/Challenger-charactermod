package mwchallenger.cards.uncommon;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.DamageHooks;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UpdateCardDescriptionAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CounterPower;
import mwchallenger.util.CardStats;

public class Patch extends BaseCard {
    public static final String ID = makeID(Patch.class.getSimpleName());
    public static final int COST = 2;
    public static final int UPG_COST = 1;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            COST
    );

    public Patch() {
        super(ID, info);
        setBlock(0);
        setCostUpgrade(UPG_COST);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        applyPowers();
        addToBot(new GainBlockAction(p,block));
    }

    @Override
    public void applyPowers() {
        this.baseBlock = AbstractDungeon.player.maxHealth - AbstractDungeon.player.currentHealth;
        super.applyPowers();
    }
}

package mwchallenger.cards.common;

import com.badlogic.gdx.scenes.scene2d.actions.RemoveAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.utility.LoseBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class NewLeaf extends BaseCard {
    public static final String ID = makeID(NewLeaf.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );
    public NewLeaf() {
        super(ID, info);
        setMagic(1,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int removeBlock = 3;
        addToBot(new LoseBlockAction(p,p,removeBlock));
        if(p.currentBlock >= removeBlock) {
            addToBot(new GainEnergyAction(magicNumber));
        }
    }
}

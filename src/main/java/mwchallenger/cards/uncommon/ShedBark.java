package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.actions.ShedBarkAction;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class ShedBark extends BaseCard {
    public static final String ID = makeID(ShedBark.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ALL_ENEMY,
            0
    );
    public ShedBark() {
        super(ID, info);
        setBlock(5);
        setMagic(2,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.applyPowers();
        addToBot(new ShedBarkAction(p,block,magicNumber));
    }
}

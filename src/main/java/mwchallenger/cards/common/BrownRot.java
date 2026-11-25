package mwchallenger.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class BrownRot extends BaseCard {
    public static final String ID = makeID(BrownRot.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public BrownRot() {
        super(ID, info);
        setMagic(3,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int dmgLastTurn = p.lastDamageTaken;
        addToBot(new ApplyPowerAction(m,p,new PoisonPower(p,p,magicNumber+dmgLastTurn),magicNumber+dmgLastTurn, AbstractGameAction.AttackEffect.POISON));

    }
}

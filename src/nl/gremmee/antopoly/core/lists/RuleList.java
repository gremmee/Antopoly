package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.rules.IRule;

public class RuleList extends ArrayList<IRule> {

    private static final long serialVersionUID = -1281054225070422189L;

    public IRule getRuleByName(final String aName) {
        for (IRule rule : this) {
            if (rule.getName().equals(aName))
                return rule;
        }
        return null;
    }

    @Override
    public boolean add(final IRule aRule) {
        System.out.println("Creating Rule " + aRule.getName() + "...[OK]");
        return super.add(aRule);

    }
}

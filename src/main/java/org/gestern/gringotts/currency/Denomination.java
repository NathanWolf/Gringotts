package org.gestern.gringotts.currency;

import org.bukkit.inventory.ItemStack;

/**
 * Representation of a denomination within a currency.
 * 
 * Note: this class has a natural ordering that is inconsistent with equals.
 * Specifically, the ordering is based purely on the value of the denomination, but not the type.
 * Conversely, the equality of denominations is based purely on their respective types, and their value is not regarded.
 * 
 * @author jast
 *
 */
public class Denomination implements Comparable<Denomination> {

    /** Item type of this denomination. */
    public final ItemStack type;
    public final int id;
    public final short damage;
    public final long value;
    public String name;
    public String namePlural;

    public Denomination(ItemStack type) {
        this(type, 0);
    }

    public Denomination(ItemStack type, long value) {
        this.type = type;
        this.id = type.getTypeId();
        this.damage = type.getDurability();
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + damage;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Denomination other = (Denomination) obj;
        return damage == other.damage && id == other.id;
    }

    @Override
    public int compareTo(Denomination other) {
        // sort in descending value order
        return Long.valueOf(other.value).compareTo(this.value);
    }

    @Override
    public String toString() {
        return String.format("Denomination: (%s) %d;%d : %d", name, id, damage, value);
    }

    public boolean hasName() {
        return this.namePlural != null && this.namePlural.length() > 0
                && this.name != null && this.name.length() > 0;
    }
}

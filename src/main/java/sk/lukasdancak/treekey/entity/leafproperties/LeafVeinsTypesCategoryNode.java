package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sk.lukasdancak.treekey.superclassentity.UniversalCategoryNode;

import java.util.Collection;

@Entity
@Table(name = "leaf_veins_types_category_nodes")
public class LeafVeinsTypesCategoryNode extends UniversalCategoryNode {


    @OneToMany(mappedBy = "leafVeinsTypesCategoryNode")
    private Collection<LeafVeinsTypeModel> leafVeinsTypes;

    public Collection<LeafVeinsTypeModel> getLeafVeinsTypes() {
        return leafVeinsTypes;
    }

    public void setLeafVeinsTypes(Collection<LeafVeinsTypeModel> leafVeinsTypes) {
        this.leafVeinsTypes = leafVeinsTypes;
    }
}

package home.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "lobby")
	public class LobbyEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "name")
		private String name;
		@ManyToOne
		@JoinColumn(name = "lobbycategory_id")
		private  LobbyCategoryEntity lobbyCategory;
		@Column(name = "image")
		private String image;
		@Column(name = "maxtable")
		private int maxTable;
		@Column(name = "min_unitpricetable")
		private Long minUnitPriceTable;
		@Column(name ="active")
		private Boolean active;
		public Boolean getActive() {
			return active;
		}
		public void setActive(Boolean active) {
			this.active = active;
		}
		public LobbyEntity id(Long id) {
			this.id = id;
			return this;
		}
		public LobbyEntity active(Boolean bool) {
			this.active = bool;
			return this;
		}
		public LobbyEntity name(String name) {
			this.name = name;
			return this;
		}
		public LobbyEntity lobbyCategory(LobbyCategoryEntity lobbyCategory) {
			this.lobbyCategory = lobbyCategory;
			return this;
		}
		public LobbyEntity image(String image) {
			this.image = image;
			return this;
		}
		public LobbyEntity maxtable(int maxtable) {
			this.maxTable = maxtable;
			return this;
		}
		public LobbyEntity minUnitPriceTable(Long minUnitPriceTable) {
			this.minUnitPriceTable = minUnitPriceTable;
			return this;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LobbyCategoryEntity getLobbyCategory() {
			return lobbyCategory;
		}
		public void setLobbyCategory(LobbyCategoryEntity lobbyCategory) {
			this.lobbyCategory = lobbyCategory;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getMaxTable() {
			return maxTable;
		}
		public void setMaxTable(int maxtable) {
			this.maxTable = maxtable;
		}
		public Long getMinUnitPriceTable() {
			return minUnitPriceTable;
		}
		public void setMinUnitPriceTable(Long min_unitpricetable) {
			this.minUnitPriceTable = min_unitpricetable;
		}
}
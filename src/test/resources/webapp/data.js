
window.sistory4 = {
	templates : {

		subCategory : '\
			<div class="large-4 medium-4 small-12 columns">\
				<li class="list-item">\
				    <div class="browse-entry">\
				        <a data-level="{2}" data-idx="{1}" href="#">\
				            <div class="img">\
				            	<img class="saved_resource">\
				            </div>\
				            <div class="bd">\
				                <div class="l-upper">\
				                	<span class="title">{0}</span>\
				                </div>\
				            </div>\
				        </a>\
				    </div>\
				</li>\
			</div>',

		resultItem :
			'<li>\
		        <article class="search-list-item">\
		            <div class="item-info ">\
		                <h2>\
		                    <a href="#">{1}</a>\
		                </h2>\
		                <p class="excerpt">{2}</p>\
		                <ul class="item-concepts comma-list">\
		                    <li>{3}</li>\
		                </ul>\
		                <div class="item-origin"><a href="#" class="external" target="_blank">{4}</a>\
		                </div>\
		                <footer>\
		                    <div class="item-metadata">\
		                        <img src="images/{5}.png">\
		                        <span class="highlight-text hide-with-grid">{6}</span>\
		                    </div>\
		                </footer>\
		            </div>\
		        </article>\
		    </li>',

		resultBanner : '<div class="results-header">\
		    <div class="result-info">1 - 6 of 1223 results</div>\
		    <div class="result-viewtype">\
		        <ul class="button-bar button-bar-small">\
		        <li class="button-bar__item">\
		            <a href="" class="button-bar__button" role="button">\
		                <img src="images/grid.png">Grid\
		            </a>\
		        </li>\
		        <li class="button-bar__item">\
		            <a href="" class="button-bar__button" role="button">\
		                <img src="images/list.png">List\
		            </a>\
		        </li>\
		        </ul>   \
		    </div>\
		</div>\
		<ol id="resultView"></ol>',

		item :
			'<section class="object-display" id="maincontent"> \
			    <div class="object-media-wrap single-item "> \
			        <div class="media-viewer">\
			            <div class="single-item-thumb">\
			                <div>\
			                    <div class="inner">\
			                        <a href="#">\
			                            <span title="Open in new tab" class="image">\
			                               <img src="images/publication.PNG">\
			                        </a>\
			                    </div>\
			                </div>\
			            </div>\
			        </div>\
			    </div>\
			    <span class="downloads">Download</span>\
			</section>',

		itemDetails : 
			'<div class="lc">\
		        <div class="object-overview">\
		            <div class="data-section no-border object-title cf">\
		                <h3 class="subsection-label">Title</h3>\
		                <div class="subsection-content">\
		                    <h2 class="object-title">Linux survival guide</h2>\
		                </div>\
		            </div>\
		            <div class="data-section cf">\
		                <h3 class="subsection-label">General</h3>\
		                <div class="subsection-content">\
		                    <ul class="data-group">\
		                        {0}\
		                    </ul>\
		                </div>\
		            </div>\
		        </div>\
			 </div>',

		itemDetailsLi : '<li>\
		    <section>\
		        <h4 class="data-header">{0}</h4>\
		        <ul class="comma-list data-group">\
		            <li><a href="#">{1}</a></li>\
		        </ul>\
		    </section>\
		 </li>'	 	

	}
};

window.publicationData =[

	{
	    naziv : "Avoid using require and incluide with PHP Autoloader",
	    desc : 'PHP code reuse can be accomplished in many ways. From PHP 5.X on, you can take advantage of autoloader. Autoloader will try to load unknow PHP class when encountered. You can register given function as a autoload implementation (providing class name to load). Together with PHP namespaces, you can make a really simple autoload function implementation, that will significanntly reduce your class names and took advantage of convention over configuration.',
	    kategorija : "Developer / Techniques",
	    tip : "PHP",
	    media : "link",
	    mediaNaziv : "Hyperlink"

	},

	{
	    naziv : " Encapsulate code that needs to be run in web context",
	    desc : "Unit tests, php CLI scripts (or even something like GEARMAN jobs ) run in different environment that php applications under server. Server provides the php runtime with bunch of stuff (taken from CGI), for example $SERVER array, or $REQUEST array. If your code is using this, it can be run only under server. ",
	    kategorija : "Developer / Techniques",
	    tip : "PHP",
	    media : "pdf",
	    mediaNaziv : "PDF Document"
	},

	{
	    naziv : "HTML5  New feature",
	    desc : " long living browser apps, that fully utilize modern browser capabilities. Usually do not use form based conversation with server, but rather utilize AJAX tecnologies to communicate with server. They could also use WebSockets for full duplex communication with server",
	    kategorija : "General info",
	    tip : "HTML5",
	    media : "pdf",
	    mediaNaziv : "PDF Document"
	},


	{
	    naziv : "HTML5 audio tag",
	    desc : "Available attributes: src — Address of the resource crossorigin — How the element handles crossorigin requests poster — Poster frame to show prior to video playback preload — Hints how much buffering the media resource will likely need autoplay — Hint that the media resource can be started automatically when the page is loaded mediagroup — Groups media elements together with an implicit MediaController loop — Whether to loop the media resource muted — Whether to mute the media resource by default controls — Show user agent controls width — Horizontal dimension height — Vertical dimension",
	    kategorija : "Developer / Audio",
	    tip : "HTML5",
	    media : "img",
	    mediaNaziv : "Picture"
	},


	{
	    naziv : "What is Maven or mvn",
	    desc : "Maven is tool for managing startup, development, testing,  release, deployment, configuration and documentation of a project. It can prepare initial project structure (or you can include it into existing project), it performs build, deploy, install, release, running of unit tests and creating project documentation documentation. The maven execution is comprised of lifecycles, which have phases, which have goals. Maven is designed to run online, and gets much of it’s configuration and information from online repositories. It can run offline too, once project is configured, and necessary artifacts are in place. Maven can handle almost everything except coding and source versioning.",
	    kategorija : "Configuration | CI",
	    tip : "Java",
	    media : "docx",
	    mediaNaziv : "Word dokument"
	},

	{
	    naziv : "How Maven resolves dependencies",
	    desc : "One of the most important things is dependency (jar, library) resolving. Maven can manega and resolve dependencies to libraries, and even the dependencies of dependencies. It can point various problems (one dependency overrides other, etc.) This was formely know as “jar hell“ (coming from “dll hell” from windows).",
	    kategorija : "Configuration | CI",
	    tip : "Java",
	    media : "pdf",
	    mediaNaziv : "PDF Document"
	}
];

window.pubDetails = [
	{
		key : "Author:",
		item: "Mitja, Guštin"
	},
	{
		key : "Language:",
		item: "English"
	},
	{
		key : "Resource type:",
		item: "PDF Document"
	},
	{
		key : "Release Year:",
		item: "2009"
	},
	{
		key : "Key words:",
		item: "linux, webserver, bach, apache2"
	},
	{
		key : "Collection:",
		item: "Webserver setup"
	},
	{
		key : "Identifier:",
		item: "MGU-ID 24001"
	}
];
package uz.context.facebookapp.model

class Feed {
    var isHeader: Boolean = false
    var post: Post? = null
    var stagger: Stagger? = null
    var stories: ArrayList<Story> = ArrayList()

    constructor() {
        this.isHeader = true
    }

    constructor(post: Post) {
        this.post = post
        this.isHeader = false
    }

    constructor(stories: ArrayList<Story>) {
        this.stories = stories
        this.isHeader = false
    }
    constructor(stagger: Stagger) {
        this.stagger = stagger
    }
}
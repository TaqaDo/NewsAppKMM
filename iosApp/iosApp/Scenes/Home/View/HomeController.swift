import UIKit


final class HomeController: UIViewController {
    
    // MARK: - Public Properties
    
    lazy var contentView: HomeViewLogic = HomeView()
    
    // MARK: - Private Properties
    
    //
    
    // MARK: - Lifecycle
    
    override func loadView() {
        view = contentView
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configure()
    }
    
    // MARK: - Requests
    
    //
    
    // MARK: - Private Methods
    
    private func configure() {
        contentView.getTitle().text = "TALA"
    }
    
    // MARK: - UI Actions
    
    //
}


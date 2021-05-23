
import SnapKit
import UIKit

protocol HomeViewLogic: UIView {
    func getTitle() -> UILabel
}

final class HomeView: UIView {
    
    // MARK: - Views
    
    private lazy var titleLabel: UILabel = {
        let label = UILabel()
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 56)
        return label
    }()
    
    //
    
    // MARK: - Init
    
    override init(frame: CGRect = CGRect.zero) {
        super.init(frame: frame)
        configure()
    }
    
    required init?(coder _: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    // MARK: - Private Methods
    
    private func configure() {
        backgroundColor = .red
        addSubviews()
        addConstraints()
    }
    
    private func addSubviews() {
        addSubview(titleLabel)
    }
    
    private func addConstraints() {
        titleLabel.snp.makeConstraints { (make) in
            make.center.equalToSuperview()
        }
    }
}

// MARK: - ProfileViewLogic

extension HomeView: HomeViewLogic {
    func getTitle() -> UILabel {
        return titleLabel
    }
}
